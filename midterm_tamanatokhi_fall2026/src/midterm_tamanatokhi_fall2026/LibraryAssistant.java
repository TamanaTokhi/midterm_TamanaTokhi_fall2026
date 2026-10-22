package midterm_tamanatokhi_fall2026;



//این کلاس معلومات کارمند کمک‌کننده کتابخانه را نگهداری می‌کند.
public class LibraryAssistant extends LibraryStaff {

 // این متغیرها شیفت کاری و امتیاز معاش را ذخیره می‌کنند.
 private final String shiftType;
 private final double shiftAllowance;

 // این متد معلومات کارمند کمک‌کننده را بررسی می‌کند.
 private static String validateAssistant(
         String staffId, String shiftType, double allowance) {

     // شماره کارمند و نوع شیفت نباید خالی باشند.
     if (staffId == null || staffId.isBlank()
             || shiftType == null || shiftType.isBlank()) {
         throw new IllegalArgumentException(
                 "Staff ID and shift type are required.");
     }

     // امتیاز شیفت نباید منفی یا نامعتبر باشد.
     if (!Double.isFinite(allowance) || allowance < 0) {
         throw new IllegalArgumentException(
                 "Shift allowance must be non-negative.");
     }

     return staffId;
 }

 // این سازنده معلومات کارمند کمک‌کننده را ذخیره می‌کند.
 public LibraryAssistant(String personId, String name, String phone,
                         String staffId, String department, double salary,
                         String shiftType, double shiftAllowance) {

     // معلومات عمومی کارمند را به کلاس پدر می‌فرستد.
     super(personId, name, phone,
             validateAssistant(staffId, shiftType, shiftAllowance),
             department, salary);

     this.shiftType = shiftType;
     this.shiftAllowance = shiftAllowance;
 }

 // معاش ماهانه کارمند کمک‌کننده را حساب می‌کند.
 @Override
 public double calculateMonthlyCompensation() {

     // امتیاز شیفت را به معاش اصلی اضافه می‌کند.
     return monthlySalary + shiftAllowance;
 }

 // نقش این شخص را مشخص می‌کند.
 @Override
 public String getRoleDescription() {
     return "Library Assistant";
 }

 // معلومات کارمند کمک‌کننده را نمایش می‌دهد.
 @Override
 public void displayStaffDetails() {
     super.displayStaffDetails();

     System.out.println("Shift Type: " + shiftType);

     // امتیاز معاش مربوط به شیفت را نمایش می‌دهد.
     System.out.printf("Shift Allowance: $%.2f%n",
             shiftAllowance);
 }
}