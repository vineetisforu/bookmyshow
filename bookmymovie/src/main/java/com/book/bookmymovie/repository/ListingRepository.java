package com.book.bookmymovie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.book.bookmymovie.model.Listing;
import com.book.bookmymovie.pojo.SearchListing;

public interface ListingRepository extends JpaRepository<Listing, Integer> {

	@Query(value = "select * from listing where id=?1", nativeQuery = true)
    public Listing getListing(int listingId);
	
	@Query(value = "select  l.id, t.name as theatreName,t.city,"
			+ "m.name as movieName,l.show_timing as showTiming,l.screen_id as ScreenId,l.price "
			+ "from listing l inner join theatre t on l.theatre_id=t.id inner join movie m on l.movie_id=m.id where t.city =?1 and l.movie_id=?2 "
			+ "and date(l.show_timing)=?3 and l.is_active is true order by l.show_timing", nativeQuery = true)
	public List<SearchListing> getListingByCityAndMovie(String city, int movieId, String date);
	
//	@Query(value = "select  new com.book.bookmymovie.pojo.SearchListing( id.id as id, t.name as theatreName,t.city as city, "
//			+ "m.name as movieName,l.show_timing as showTiming,l.screen_id as screenId,l.price as price, id.seat_name as seatName) "
//			+ "from listing l inner join theatre t on l.theatre_id=t.id inner join movie m on l.movie_id=m.id inner join inventory_details id on l.id=id.listing_id where "
//			+ "l.is_active is true and id.available is true and l.id = :listingId and id.seat_name in (:seats) order by l.show_timing")
	@Query(value = "select  new com.book.bookmymovie.pojo.SearchListing( id.id, t.name,t.city, "
			+ "m.name,l.showTiming,l.screenId,l.price, id.seatName) "
			+ "from Listing l inner join Theatre t on l.theatreId=t.id inner join Movie m on l.movieId=m.id inner join InventoryDetails id on l.id=id.listingId where "
			+ "l.isActive is true and id.available is true and l.id = ?1 and id.seatName in (?2) order by l.showTiming")

	public List<SearchListing> getSeatWiseListing(int listingId, List<String> seats);
}

