
TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
 click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var name : String = "Fayy"
    name = "Fayza Zeevania"
    println(name)
}
fun main() {
    val name: String = "Fayy"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    name = "Fayza Zeevania"
    println(name)
}
fun main() {
    var score : Int = 100

    println("Score " + score++)
    println("Score " + score++)
    println("Score " + score++)
    println("")
    println("Score " + score--)
    println("Score " + score--)
    println("Score " + score--)
}
fun main () {
    val stringText = "Semenjak Ada dirimu"
    val stringText2 = "Apakah Penyanyi ini \ndari \"Juicy Luicy\"? "
    val statement = """
        Penyanyi Lagu Semenjak Ada Dirimu
        ---------------------------------
        Andity (2021)
    """.trimIndent()
    val firstChar = stringText[4]

    println("Huruf Ke-5 dari $stringText adalah $firstChar")
    println("")
    println(stringText2)
    println("")
    println(statement)
}
fun main () {
    var x =true
    var y = false

    println(" x && y =" + (x && y))
    println("x || y =" + (x || y))
    println("!y =" + (!y))
}
fun main () {
    val x: Int = 10
    val y: Int = 25

    println("x > y = " + (x > y))
    println("x < y = " + (x < y))
    println("x == y = " + (x == y))
    println("x >= y = " + (x >= y))
    println("x <= y = " + (x <= y))
    println("x != y = " + (x != y))
}
fun main () {
    val skincare = arrayOf<String>("Mouisturizer", "Sunscreen", "Lipbalm", "Toner")

    println(skincare[0])
    println(skincare.get(1))
    println("-----------------")

    skincare[0] = "Originote"
    skincare.set(1, "Azarine")

    println(skincare[0])
    println(skincare.get(2))
    println(skincare.get(1))
    println(skincare.get(3))
}
fun main () {
    val charArray = charArrayOf('a', 'b', 'c', 'd', 'e', 'f')
    charArray[2] = 'l'

    println(charArray)
}
fun main (){
    val a: Int = 20000
    val d: Double = 20000.0
    val f: Float = 240.0f
    val l: Long = 2120000004L
    val s: Short = 40
    val b: Byte = Byte.MAX_VALUE

    println("Nilai Int = " + a)
    println("Nilai Double " + d)
    println("Nilai Float " + f)
    println("Nilai Short " + s)
    println("Nilai Long " + l)
    println("Nilai Byte " + b)
}
fun faculty(
    firstWord: String,
    middleWord: String,
    lastWord: String
) {
    println(" Saya dari $firstWord $middleWord $lastWord")
}
fun main() {
    faculty(
        firstWord = "Fakultas",
        middleWord = "Teknologi",
        lastWord = "Informasi"
    )
fun haii(firstWord: String, secondWord: String = "") {
    println("Hello, $firstWord $secondWord")
}
fun main (){
    haii("Infinite")
    haii("Infinite", "Learning")
}
fun sapa(namaPertama: String, namaKedua: String, namaKetiga: String){
    println("Sapa $namaPertama $namaKedua $namaKetiga")
}
fun main(){
    sapa("Fayza", "Zeevania", "Putri")
}
fun sapa(){
    println("Sapa")
    println("Dunia")
    println("Tipu-Tipu")
}
fun main(){
    sapa()
}
fun main(){
    val makanan = "Siomay"
    val rating = 9
    print ("Aku lapar pengen " + makanan)
    println ("")
    print ("Aku lapar pengen $makanan")
    print ("\nRating $makanan ${if (rating >=8)
        "Enak!!" else "Jangan dibelii"}")
}
fun main() {
    val price: Double? = 100.0
    val discountPercentage: Double? = 10.0

    if (price != null && price >= 0 && discountPercentage !=
        null && discountPercentage >= 0) {
        val maxDiscount = 50.0
        val discountPercentageToUse = if (discountPercentage > maxDiscount)
            maxDiscount else discountPercentage
        val discountAmount = discountPercentageToUse * price / 100
        val totalPrice = price - discountAmount
        println("Total harga: Rp$totalPrice")
    } else {
        println("Harga atau persentase diskon tidak valid.")
    }
}

//}
