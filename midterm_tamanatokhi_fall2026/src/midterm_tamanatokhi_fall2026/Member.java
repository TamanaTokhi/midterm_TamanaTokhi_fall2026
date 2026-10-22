package midterm_tamanatokhi_fall2026;



//این کلاس معلومات اعضای کتابخانه را نگهداری می‌کند.
public class Member extends Person {

 // این متغیرها معلومات مخصوص عضو را ذخیره می‌کنند.
 private final String memberNumber;
 private final int age;
 private final String membershipType;

 // این متغیر فیس باقی‌مانده عضو را نگهداری می‌کند.
 private double outstandingFees;

 // این متد بررسی می‌کند که معلومات عضو درست باشد.
 private static String validateMember(
         String personId, String name, String phone,
         String memberNumber, int age, String membershipType) {

     // بررسی معلومات اساسی شخص.
     if (personId == null || personId.isBlank()
             || name == null || name.isBlank()
             || phone == null || phone.isBlank()) {
         throw new IllegalArgumentException(
                 "Person details are required.");
     }

     // بررسی شماره عضویت.
     if (memberNumber == null || memberNumber.isBlank()) {
         throw new IllegalArgumentException(
                 "Member number is required.");
     }

     // سن عضو باید حداقل ۱۸ و حداکثر ۱۲۰ باشد.
     if (age < 18 || age > 120) {
         throw new IllegalArgumentException(
                 "Age must be between 18 and 120.");
     }

     // نوع عضویت نباید خالی باشد.
     if (membershipType == null || membershipType.isBlank()) {
         throw new IllegalArgumentException(
                 "Membership type is required.");
     }

     // اگر معلومات درست باشد، شماره شخص را برمی‌گرداند.
     return personId;
 }

 // این سازنده معلومات عضو را ذخیره می‌کند.
 public Member(String personId, String name, String phone,
               String memberNumber, int age, String membershipType) {

     // معلومات مشترک شخص را به کلاس پدر می‌فرستد.
     super(validateMember(personId, name, phone,
             memberNumber, age, membershipType), name, phone);

     // معلومات مخصوص عضو را ذخیره می‌کند.
     this.memberNumber = memberNumber;
     this.age = age;
     this.membershipType = membershipType;

     // در شروع، عضو هیچ فیس باقی‌مانده ندارد.
     this.outstandingFees = 0;
 }

 // این متد عضو را با نوع عضویت عادی ثبت می‌کند.
 public static Member registerMember(
         String personId, String name, String phone,
         String memberNumber, int age) {

     // اگر نوع عضویت داده نشود، Standard انتخاب می‌شود.
     return new Member(personId, name, phone,
             memberNumber, age, "Standard");
 }

 // این متد عضو را با نوع عضویت انتخاب‌شده ثبت می‌کند.
 public static Member registerMember(
         String personId, String name, String phone,
         String memberNumber, int age, String membershipType) {

     return new Member(personId, name, phone,
             memberNumber, age, membershipType);
 }

 // این متد فیس باقی‌مانده عضو را زیاد می‌کند.
 public void addOutstandingFees(double amount) {

     // مقدار فیس نباید منفی یا نامعتبر باشد.
     if (!Double.isFinite(amount) || amount < 0) {
         throw new IllegalArgumentException(
                 "Fee must be non-negative.");
     }

     // فیس جدید را به فیس قبلی اضافه می‌کند.
     outstandingFees += amount;
 }

 // این متد شماره عضویت را برمی‌گرداند.
 public String getMemberNumber() {
     return memberNumber;
 }

 // این متد فیس باقی‌مانده را برمی‌گرداند.
 public double getOutstandingFees() {
     return outstandingFees;
 }

 // نقش این شخص را به عنوان عضو کتابخانه مشخص می‌کند.
 @Override
 public String getRoleDescription() {
     return "Library Member";
 }

 // تمام معلومات عضو را نمایش می‌دهد.
 public void displayMemberDetails() {

     // اول معلومات اساسی شخص را نمایش می‌دهد.
     displayBasicDetails();

     // بعد معلومات مخصوص عضویت را نمایش می‌دهد.
     System.out.println("Member Number: " + memberNumber);
     System.out.println("Age: " + age);
     System.out.println("Membership Type: " + membershipType);

     // فیس را با دو رقم بعد از اعشار نمایش می‌دهد.
     System.out.printf("Outstanding Fees: $%.2f%n",
             outstandingFees);
 }
}