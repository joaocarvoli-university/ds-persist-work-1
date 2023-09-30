import model.Product
import model.ProductCategory
import service.dataProfiling.CSVSummary
import service.fileHandler.reader.CSVReader
import service.fileHandler.writer.CSVWriter
import service.fileHandler.writer.Writeable
import java.util.logging.FileHandler

fun main(args: Array<String>){
    // Question 02 - part 1
    val products = initializingProducts()

    val csvWriter = CSVWriter<Product>()
    products.forEach {
        csvWriter.loadObject(it)
        csvWriter.writes("products")
    }

    // Question 02 - part 2
    println(CSVSummary.getEntitiesAmount("products"))

    // Question 02 - part 3


}

private fun initializingProducts(): MutableList<Product> {
    val toothpaste = Product("ToohPaste Tube", 1.90, "Colgate", "02032023", "02032023", ProductCategory.PERSONAL_HYGIENE)
    val soap = Product("Soap", 2.30, "Nivea", "12052023", "12122023", ProductCategory.PERSONAL_HYGIENE)
    val shampoo = Product("Shampoo", 4.50, "Pantene", "15072024", "15102024", ProductCategory.PERSONAL_HYGIENE)
    val toothbrush = Product("Toothbrush", 1.20, "Oral-B", "01052025", "01052025", ProductCategory.PERSONAL_HYGIENE)
    val laundryDetergent = Product("Laundry Detergent", 8.75, "Tide", "23012024", "23012024", ProductCategory.CLEANING)
    val handSanitizer = Product("Hand Sanitizer", 3.99, "Purell", "31122025", "31122025", ProductCategory.PERSONAL_HYGIENE)
    val dishSoap = Product("Dish Soap", 2.75, "Dawn", "18032024", "18032024", ProductCategory.CLEANING)
    val deodorant = Product("Deodorant", 2.99, "Secret", "10062025", "10062025", ProductCategory.PERSONAL_HYGIENE)
    val windowCleaner = Product("Window Cleaner", 3.25, "Windex", "04122023", "04122023", ProductCategory.CLEANING)
    val bodyWash = Product("Body Wash", 5.75, "Dove", "22092024", "22092024", ProductCategory.PERSONAL_HYGIENE)
    val floorCleaner = Product("Floor Cleaner", 6.50, "Mr. Clean", "07102023", "07102023", ProductCategory.CLEANING)
    val handCream = Product("Hand Cream", 2.99, "Neutrogena", "15042025", "15042025", ProductCategory.PERSONAL_HYGIENE)

    val products = mutableListOf<Product>()
    products.add(toothpaste)
    products.add(soap)
    products.add(shampoo)
    products.add(toothbrush)
    products.add(laundryDetergent)
    products.add(handSanitizer)
    products.add(dishSoap)
    products.add(deodorant)
    products.add(windowCleaner)
    products.add(bodyWash)
    products.add(floorCleaner)
    products.add(handCream)

    return products
}