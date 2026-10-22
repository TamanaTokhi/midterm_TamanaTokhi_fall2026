package midterm_tamanatokhi_fall2026;



//این کلاس معلومات و وظایف کتابدار را نگهداری می‌کند.
public class Librarian extends LibraryStaff {

 // این متغیرها محدودیت و تعداد کتاب‌های بررسی‌شده را ذخیره می‌کنند.
 private final int dailyIssueLimit;
 private final int booksProcessed;

 // این متد معلومات مخصوص کتابدار را بررسی می‌کند.
 private static String validateLibrarian(
         String staffId, int dailyIssueLimit, int booksProcessed) {

     // شماره کارمند نباید خالی باشد.
     if (staffId == null || staffId.isBlank()) {
         throw new IllegalArgumentException(
                 "Staff ID is required.");
     }

     // تعداد کتاب‌ها و محدودیت روزانه نباید منفی باشد.
     if (dailyIssueLimit < 0 || booksProcessed < 0) {
         throw new IllegalArgumentException(
                 "Book limits cannot be negative.");
     }

     return staffId;
 }

 // این سازنده معلومات کتابدار را ذخیره می‌کند.
 public Librarian(String personId, String name, String phone,
                  String staffId, String department, double salary,
                  int dailyIssueLimit, int booksProcessed) {

     // معلومات کارمند را به کلاس پدر می‌فرستد.
     super(personId, name, phone,
             validateLibrarian(staffId, dailyIssueLimit, booksProcessed),
             department, salary);

     this.dailyIssueLimit = dailyIssueLimit;
     this.booksProcessed = booksProcessed;
 }

 // معاش کتابدار را حساب می‌کند.
 @Override
 public double calculateMonthlyCompensation() {

     // به معاش اصلی، برای هر کتاب بررسی‌شده دو دالر اضافه می‌شود.
     return monthlySalary + booksProcessed * 2.00;
 }

 // این متد فیس کتاب دیرکرده را با نرخ عادی حساب می‌کند.
 public double calculateLateFee(int daysOverdue) {

     // نرخ عادی برای هر روز یک دالر است.
     return calculateLateFee(daysOverdue, 1.00);
 }

 // این متد فیس را با تعداد روزها و نرخ انتخاب‌شده حساب می‌کند.
 public double calculateLateFee(int daysOverdue, double dailyRate) {

     // تعداد روزهای دیرکرده نباید منفی باشد.
     if (daysOverdue < 0) {
         throw new IllegalArgumentException(
                 "Overdue days cannot be negative.");
     }

     // نرخ روزانه نباید منفی یا نامعتبر باشد.
     if (!Double.isFinite(dailyRate) || dailyRate < 0) {
         throw new IllegalArgumentException(
                 "Daily rate must be non-negative.");
     }

     // تعداد روزها را در نرخ روزانه ضرب می‌کند.
     return daysOverdue * dailyRate;
 }

 // نقش این شخص را به عنوان کتابدار مشخص می‌کند.
 @Override
 public String getRoleDescription() {
     return "Librarian";
 }

 // معلومات کارمند را همراه با معلومات مخصوص کتابدار نمایش می‌دهد.
 @Override
 public void displayStaffDetails() {
     super.displayStaffDetails();

     System.out.println("Daily Issue Limit: " + dailyIssueLimit);
     System.out.println("Books Processed: " + booksProcessed);
 }
}