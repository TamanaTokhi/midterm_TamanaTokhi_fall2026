package midterm_tamanatokhi_fall2026;


//این interface برای درخواست رزرو کتاب استفاده می‌شود.
public interface Reservable {

 // این متد شماره کتاب را می‌گیرد.
 // اگر درخواست موفق باشد true و اگر ناموفق باشد false برمی‌گرداند.
 boolean reserveBook(String bookId);
}