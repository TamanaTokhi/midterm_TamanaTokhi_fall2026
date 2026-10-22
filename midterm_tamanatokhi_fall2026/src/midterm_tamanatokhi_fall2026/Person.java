package midterm_tamanatokhi_fall2026;

	

//این کلاس معلومات اساسی تمام اشخاص را نگهداری می‌کند.
public abstract class Person {

 // این متغیرها معلومات شخص را ذخیره می‌کنند.
 private final String personId;
 private final String name;
 private final String phoneNumber;

 // این متغیر تعداد تمام اشخاص ساخته‌شده را حساب می‌کند.
 private static int personCount = 0;

 // این سازنده معلومات شخص را می‌گیرد.
 public Person(String personId, String name, String phoneNumber) {

     // بررسی می‌کند که معلومات ضروری خالی نباشد.
     if (personId == null || personId.isBlank()
             || name == null || name.isBlank()
             || phoneNumber == null || phoneNumber.isBlank()) {

         // اگر معلومات ناقص باشد، خطا نشان می‌دهد.
         throw new IllegalArgumentException(
                 "Person ID, name, and phone are required.");
     }

     // معلومات شخص را ذخیره می‌کند.
     this.personId = personId;
     this.name = name;
     this.phoneNumber = phoneNumber;

     // تعداد اشخاص را یک دانه زیاد می‌کند.
     personCount++;
 }

 // این متد شماره شخص را برمی‌گرداند.
 public String getPersonId() {
     return personId;
 }

 // این متد نام شخص را برمی‌گرداند.
 public String getName() {
     return name;
 }

 // این متد شماره تلفون را برمی‌گرداند.
 public String getPhoneNumber() {
     return phoneNumber;
 }

 // این متد تعداد تمام اشخاص را برمی‌گرداند.
 public static int getPersonCount() {
     return personCount;
 }

 // این متد معلومات اساسی شخص را نمایش می‌دهد.
 public void displayBasicDetails() {
     System.out.println("Person ID: " + personId);
     System.out.println("Name: " + name);
     System.out.println("Phone: " + phoneNumber);

     // این متد نقش شخص را از کلاس مربوطه می‌گیرد.
     System.out.println("Role: " + getRoleDescription());
 }

 // هر کلاس فرزند باید نقش خودش را مشخص کند.
 public abstract String getRoleDescription();

 // این متد معلومات شخص را به شکل یک متن برمی‌گرداند.
 @Override
 public String toString() {
     return "Person ID: " + personId
             + ", Name: " + name
             + ", Phone: " + phoneNumber
             + ", Role: " + getRoleDescription();
 }
}