package midterm_tamanatokhi_fall2026;



//این کلاس پدر کارمندان کتابخانه است.
public abstract class LibraryStaff extends Person {

 // این متغیرها معلومات کارمند را ذخیره می‌کنند.
 private final String staffId;
 private final String department;

 // این متغیر معاش ماهانه را نگهداری می‌کند.
 protected final double monthlySalary;

 // این متغیر تعداد تمام کارمندان را حساب می‌کند.
 private static int staffCount = 0;

 // این متد معلومات کارمند را بررسی می‌کند.
 private static String validateStaff(
         String personId, String name, String phone,
         String staffId, String department, double salary) {

     // معلومات ضروری نباید خالی باشد.
     if (personId == null || personId.isBlank()
             || name == null || name.isBlank()
             || phone == null || phone.isBlank()
             || staffId == null || staffId.isBlank()
             || department == null || department.isBlank()) {
         throw new IllegalArgumentException(
                 "All staff details are required.");
     }

     // معاش نباید منفی یا نامعتبر باشد.
     if (!Double.isFinite(salary) || salary < 0) {
         throw new IllegalArgumentException(
                 "Salary must be non-negative.");
     }

     // اگر معلومات درست باشد، شماره شخص را برمی‌گرداند.
     return personId;
 }

 // این سازنده معلومات کارمند را ذخیره می‌کند.
 public LibraryStaff(String personId, String name, String phone,
                     String staffId, String department,
                     double monthlySalary) {

     // معلومات اساسی را به کلاس پدر می‌فرستد.
     super(validateStaff(personId, name, phone,
             staffId, department, monthlySalary), name, phone);

     // معلومات کارمند را ذخیره می‌کند.
     this.staffId = staffId;
     this.department = department;
     this.monthlySalary = monthlySalary;

     // تعداد کارمندان را یک دانه زیاد می‌کند.
     staffCount++;
 }

 // این متد تعداد تمام کارمندان را برمی‌گرداند.
 public static int getStaffCount() {
     return staffCount;
 }

 // هر نوع کارمند باید طریقه حساب معاش خود را مشخص کند.
 public abstract double calculateMonthlyCompensation();

 // این متد معلومات کارمند و معاش او را نمایش می‌دهد.
 public void displayStaffDetails() {
     displayBasicDetails();

     System.out.println("Staff ID: " + staffId);
     System.out.println("Department: " + department);

     // معاش اصلی ماهانه را نمایش می‌دهد.
     System.out.printf("Monthly Salary: $%.2f%n",
             monthlySalary);

     // معاش نهایی را با استفاده از متد همان کارمند حساب می‌کند.
     System.out.printf("Monthly Compensation: $%.2f%n",
             calculateMonthlyCompensation());
 }
}