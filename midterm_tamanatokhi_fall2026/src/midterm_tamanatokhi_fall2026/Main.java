package midterm_tamanatokhi_fall2026;



//این کلاس دو interface را استفاده می‌کند:
//یکی برای ساختن گزارش و دیگری برای درخواست رزرو.
public class Main implements Reportable, Reservable {

 // این متد درخواست رزرو کتاب را بررسی می‌کند.
 @Override
 public boolean reserveBook(String bookId) {

     // اگر شماره کتاب خالی باشد، درخواست قبول نمی‌شود.
     if (bookId == null || bookId.isBlank()) {
         System.out.println(
                 "Reservation failed: Book ID is required.");
         return false;
     }

     // اگر شماره کتاب موجود باشد، درخواست ثبت می‌شود.
     System.out.println(
             "Reservation request received for book: " + bookId);

     return true;
 }

 // این متد گزارش خلاصه کتابخانه را می‌سازد.
 @Override
 public void generateReport() {
     System.out.println("\n--- Library Summary Report ---");

     // تعداد تمام اشخاص را نمایش می‌دهد.
     System.out.println(
             "Total people: " + Person.getPersonCount());

     // تعداد تمام کارمندان را نمایش می‌دهد.
     System.out.println(
             "Total staff: " + LibraryStaff.getStaffCount());
 }

 // این متد تعداد اعضایی را که ثبت شده‌اند حساب می‌کند.
 public static int countMembers(Member member1, Member member2) {
     int count = 0;

     // اگر عضو اول ثبت شده باشد، تعداد را یک دانه زیاد می‌کند.
     if (member1 != null) {
         count++;
     }

     // اگر عضو دوم ثبت شده باشد، تعداد را یک دانه زیاد می‌کند.
     if (member2 != null) {
         count++;
     }

     return count;
 }

 // اجرای برنامه از این متد شروع می‌شود.
 public static void main(String[] args) {

     System.out.println("================================");
     System.out.println(" MAPLE LEAF PUBLIC LIBRARY");
     System.out.println("================================");

     // -------------------------------
     // ثبت اعضای کتابخانه
     // -------------------------------
     System.out.println("\n--- Member Registration ---");

     // در شروع، هنوز هیچ عضوی ثبت نشده است.
     Member member1 = null;
     Member member2 = null;

     try {
         // عضو اول با نوع عضویت عادی ثبت می‌شود.
         member1 = Member.registerMember(
                 "P101", "Tamana", "416-555-0101", "M101", 25);

         System.out.println(
                 "Registration successful: " + member1.getName());

         // عضو دوم با نوع عضویت Premium ثبت می‌شود.
         member2 = Member.registerMember(
                 "P102", "Sara", "416-555-0102",
                 "M102", 30, "Premium");

         System.out.println(
                 "Registration successful: " + member2.getName());

     } catch (IllegalArgumentException e) {

         // اگر معلومات ثبت نام نادرست باشد، خطا را نمایش می‌دهد.
         System.out.println(
                 "Registration failed: " + e.getMessage());
     }

     // آزمایش ثبت نام ناموفق با سن نادرست.
     try {
         Member.registerMember(
                 "P103", "Invalid Member",
                 "416-555-0103", "M103", 12);

     } catch (IllegalArgumentException e) {

         // دلیل قبول‌نشدن ثبت نام را نمایش می‌دهد.
         System.out.println(
                 "Invalid registration: " + e.getMessage());
     }

     // -------------------------------
     // نمایش معلومات اعضا
     // -------------------------------
     System.out.println("\n--- Member Details ---");

     // اگر عضو اول ثبت شده باشد، معلوماتش نمایش داده می‌شود.
     if (member1 != null) {

         // پنج دالر فیس به حساب عضو اضافه می‌کند.
         member1.addOutstandingFees(5.00);

         // معلومات عضو اول را نمایش می‌دهد.
         member1.displayMemberDetails();
     }

     // اگر عضو دوم ثبت شده باشد، معلوماتش نمایش داده می‌شود.
     if (member2 != null) {
         member2.displayMemberDetails();
     }

     // -------------------------------
     // ساختن کارمندان کتابخانه
     // -------------------------------
     System.out.println("\n--- Library Staff ---");

     // ساختن یک کتابدار.
     Librarian librarian = new Librarian(
             "P201", "Ali", "416-555-0201",
             "S201", "Circulation", 4000, 50, 100);

     // ساختن یک کتابدار ارشد.
     SeniorLibrarian senior = new SeniorLibrarian(
             "P202", "Mary", "416-555-0202",
             "S202", "Management", 5000,
             60, 150, "Research", 500);

     // ساختن یک کارمند کمک‌کننده کتابخانه.
     LibraryAssistant assistant = new LibraryAssistant(
             "P203", "John", "416-555-0203",
             "S203", "Customer Service",
             3000, "Evening", 200);

     // نمایش معلومات کتابدار.
     librarian.displayStaffDetails();

     System.out.println();

     // نمایش معلومات کتابدار ارشد.
     senior.displayStaffDetails();

     System.out.println();

     // نمایش معلومات کارمند کمک‌کننده.
     assistant.displayStaffDetails();

     // -------------------------------
     // حساب فیس دیرکرد کتاب
     // -------------------------------
     System.out.println("\n--- Late Fee Calculation ---");

     // فیس پنج روز دیرکرد با نرخ عادی حساب می‌شود.
     System.out.printf("5 days at default rate: $%.2f%n",
             librarian.calculateLateFee(5));

     // فیس پنج روز دیرکرد با نرخ یک‌ونیم دالر حساب می‌شود.
     System.out.printf("5 days at $1.50 per day: $%.2f%n",
             librarian.calculateLateFee(5, 1.50));

     // آزمایش روزهای دیرکرد منفی.
     try {
         librarian.calculateLateFee(-2);

     } catch (IllegalArgumentException e) {

         // خطای مربوط به روزهای منفی را نمایش می‌دهد.
         System.out.println("Late fee error: " + e.getMessage());
     }

     // -------------------------------
     // نمایش Runtime Polymorphism
     // -------------------------------
     System.out.println("\n--- Runtime Polymorphism ---");

     // هر سه کارمند در یک آرایه از نوع LibraryStaff قرار می‌گیرند.
     LibraryStaff[] staffMembers = {
             librarian, senior, assistant
     };

     // Java برای هر کارمند متد مناسب همان کلاس را اجرا می‌کند.
     for (LibraryStaff staff : staffMembers) {

         // نام و وظیفه کارمند را نمایش می‌دهد.
         System.out.println(
                 staff.getName() + " - "
                         + staff.getRoleDescription());

         // معاش مخصوص همان کارمند را حساب می‌کند.
         System.out.printf("Monthly compensation: $%.2f%n",
                 staff.calculateMonthlyCompensation());
     }

     // -------------------------------
     // آزمایش interface ها
     // -------------------------------
     System.out.println("\n--- Interface Demonstration ---");

     // ساختن یک شیء از کلاس Main.
     Main application = new Main();

     // استفاده از interface برای درخواست رزرو.
     Reservable reservation = application;

     // آزمایش درخواست رزرو با شماره کتاب.
     reservation.reserveBook("B101");

     // آزمایش درخواست رزرو با شماره خالی.
     reservation.reserveBook("");

     // استفاده از interface برای ساختن گزارش.
     Reportable report = application;

     // ساختن گزارش خلاصه کتابخانه.
     report.generateReport();

     // -------------------------------
     // نمایش انواع وراثت
     // -------------------------------
     System.out.println("\n--- Inheritance Concepts ---");

     // یک کلاس از یک کلاس دیگر ارث می‌گیرد.
     System.out.println("Single: Member extends Person.");

     // وراثت در چند مرحله انجام می‌شود.
     System.out.println(
             "Multilevel: Person -> LibraryStaff -> Librarian -> SeniorLibrarian.");

     // چند کلاس از یک کلاس پدر ارث می‌گیرند.
     System.out.println(
             "Hierarchical: Librarian and LibraryAssistant extend LibraryStaff.");

     // وراثت کلاس‌ها همراه با استفاده از interface ها.
     System.out.println(
             "Hybrid: Class inheritance combined with interfaces.");

     // در Java یک کلاس نمی‌تواند از دو کلاس ارث بگیرد،
     // اما می‌تواند چند interface را استفاده کند.
     System.out.println(
             "Java classes cannot extend multiple classes, "
                     + "but can implement multiple interfaces.");

     // -------------------------------
     // نمایش شمارنده‌ها
     // -------------------------------
     System.out.println("\n--- Static Counters ---");

     // تعداد تمام اشخاص را نمایش می‌دهد.
     System.out.println(
             "Total people: " + Person.getPersonCount());

     // تعداد اعضای ثبت‌شده در این برنامه را نمایش می‌دهد.
     System.out.println(
             "Total members: " + countMembers(member1, member2));

     // تعداد کارمندان را نمایش می‌دهد.
     System.out.println(
             "Total staff: " + LibraryStaff.getStaffCount());

     System.out.println("\nProgram completed.");
 }
}
