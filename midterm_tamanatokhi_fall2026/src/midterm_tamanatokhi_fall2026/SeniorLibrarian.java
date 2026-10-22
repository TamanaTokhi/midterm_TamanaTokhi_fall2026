package midterm_tamanatokhi_fall2026;



//این کلاس کتابدار ارشد را نشان می‌دهد.
//کتابدار ارشد از کلاس Librarian ارث می‌گیرد.
public class SeniorLibrarian extends Librarian {

 // این متغیرها تخصص و امتیاز معاش کتابدار ارشد را ذخیره می‌کنند.
 private final String specialization;
 private final double seniorityAllowance;

 // این متد معلومات کتابدار ارشد را بررسی می‌کند.
 private static String validateSenior(
         String staffId, String specialization, double allowance) {

     // شماره کارمند و تخصص نباید خالی باشند.
     if (staffId == null || staffId.isBlank()
             || specialization == null || specialization.isBlank()) {
         throw new IllegalArgumentException(
                 "Staff ID and specialization are required.");
     }

     // امتیاز معاش نباید منفی یا نامعتبر باشد.
     if (!Double.isFinite(allowance) || allowance < 0) {
         throw new IllegalArgumentException(
                 "Seniority allowance must be non-negative.");
     }

     return staffId;
 }

 // این سازنده معلومات کتابدار ارشد را ذخیره می‌کند.
 public SeniorLibrarian(String personId, String name, String phone,
                        String staffId, String department, double salary,
                        int dailyIssueLimit, int booksProcessed,
                        String specialization, double seniorityAllowance) {

     // معلومات کتابدار را به کلاس پدر می‌فرستد.
     super(personId, name, phone,
             validateSenior(staffId, specialization, seniorityAllowance),
             department, salary, dailyIssueLimit, booksProcessed);

     this.specialization = specialization;
     this.seniorityAllowance = seniorityAllowance;
 }

 // معاش کتابدار ارشد را حساب می‌کند.
 @Override
 public double calculateMonthlyCompensation() {

     // معاش کتابدار را گرفته و امتیاز ارشدیت را اضافه می‌کند.
     return super.calculateMonthlyCompensation() + seniorityAllowance;
 }

 // نقش این شخص را مشخص می‌کند.
 @Override
 public String getRoleDescription() {
     return "Senior Librarian";
 }

 // معلومات کتابدار ارشد را نمایش می‌دهد.
 @Override
 public void displayStaffDetails() {
     super.displayStaffDetails();

     System.out.println("Specialization: " + specialization);

     // امتیاز اضافی معاش را نمایش می‌دهد.
     System.out.printf("Seniority Allowance: $%.2f%n",
             seniorityAllowance);

     // مجموع نهایی معاش را نمایش می‌دهد.
     System.out.printf("Total Compensation: $%.2f%n",
             calculateMonthlyCompensation());
 }
}