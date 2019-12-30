package ex04__Gigasecond;

import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime dateTime;
    private static final int GIGA_SECOND = 1_000_000_000;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        this.dateTime = moment.plusSeconds(GIGA_SECOND);
    }

    LocalDateTime getDateTime() {
        return this.dateTime;
    }

}

//other solutions:


//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//import static java.time.temporal.ChronoUnit.SECONDS;
//
//class Gigasecond {
//
//    private LocalDateTime dateTime;
//
//    private static LocalDateTime addGigasecond(LocalDateTime moment) {
//        return moment.plus((long) Math.pow(10, 9), SECONDS);
//    }
//
//    Gigasecond(LocalDate moment) {
//        this.dateTime = addGigasecond(moment.atStartOfDay());
//    }
//
//    Gigasecond(LocalDateTime moment) {
//        this.dateTime = addGigasecond(moment);
//
//    }
//
//    LocalDateTime getDateTime() {
//        return this.dateTime;
//    }
//
//}


//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//public class Gigasecond {
//    private final LocalDateTime birthday;
//
//    public Gigasecond(LocalDate birthday) {
//        this(birthday.atStartOfDay());
//    }
//
//    public Gigasecond(LocalDateTime birthday) {
//        this.birthday = birthday;
//    }
//
//    public LocalDateTime getDate() {
//        return birthday.plusSeconds(1_000_000_000);
//    }
//}


//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//class Gigasecond {
//
//    private LocalDateTime dateTime;
//
//    Gigasecond(LocalDate birthDate) {
//        dateTime = birthDate.atTime(0,0);
//    }
//
//    Gigasecond(LocalDateTime birthDateTime) {
//        dateTime = birthDateTime;
//    }
//
//    LocalDateTime getDate() {
//        return dateTime.plusSeconds(1000000000);
//    }
//
//}


//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.LocalDateTime;
//
///**
// * Store a time stamp and calculate the time stamp after 1 gigasecond.
// * @author olpa
// */
//public class Gigasecond {
//	/** The object timestamp */
//	private final LocalDateTime localDate;
//	/** Literal value for 1 giga */
//	private final static long GIGA = 1_000_000_000L;
//
//	/**
//	 * Construct the object.
//	 * @param localDate Base time stamp.
//	 */
//	public Gigasecond(final LocalDate localDate) {
//		this.localDate = LocalDateTime.of(localDate, LocalTime.of(0, 0));
//	}
//
//	/**
//	 * Construct the object.
//	 * @param localDate Base time stamp.
//	 */
//	public Gigasecond(final LocalDateTime localDate) {
//		this.localDate = localDate;
//	}
//
//	/**
//	 * Calculate the time stamp after 1 gigaseconds.
//	 * @return Time stamp after 1 gigaseconds.
//	 */
//	public LocalDateTime getDate() {
//		return localDate.plusSeconds(GIGA);
//	}
//}


//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//public class Gigasecond {
//
//	private LocalDateTime gigasecond;
//	private final long offset = (long) 1e9;
//
//	public Gigasecond(LocalDate date) {
//		gigasecond = date.atTime(0,0).plusSeconds(offset);
//	}
//
//	public Gigasecond(LocalDateTime date) {
//		gigasecond = date.plusSeconds(offset);
//	}
//
//	public LocalDateTime getDate() {
//		return gigasecond;
//	}
//}