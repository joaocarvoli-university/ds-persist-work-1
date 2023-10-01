package ui.screens.registerData

import model.Product
import model.ProductCategory
import service.fileWriter.CSVWriter
import java.lang.Exception

object RegisterProduct {
    fun showOptions(){
        println("\nInsert values for the product entity")
        print("> name: ")
        val productNameInput = readln()
        print("> price: ")
        val productPriceInput = readln()
        print("> manufacturer: ")
        val productManufacturerInput = readln()
        print("> manufacturing date (format dd/mm/yy): ")
        val productManufacturingDateInput = readln()
        print("> expiration date (format dd/mm/yy): ")
        val productExpirationDateInput = readln()
        println("> category: ")
        ProductCategory.values().dropLast(1).forEachIndexed { index, productCategory ->
            println("(${index + 1}) - $productCategory")
        }
        print("> insert value: ")
        val productCategoryInput = readln()

        if(createProduct(productNameInput, productPriceInput, productManufacturerInput,
                productManufacturingDateInput, productExpirationDateInput, productCategoryInput)){
            println("Product created successfully")
        } else println("Problem in data insertion")
    }

    private fun createProduct(
        name: String, price: String, manufacturer: String,
        manufacturingDate: String, expirationDate: String, category: String): Boolean{

        val csvWriter = CSVWriter<Product>()

        return try {
            val productCategory = if(category.toInt() == 1) ProductCategory.CLEANING else ProductCategory.PERSONAL_HYGIENE
            val product = Product(name, price.toDouble(), manufacturer, manufacturingDate, expirationDate, productCategory)
            csvWriter.loadObject(product)
            csvWriter.writes("products")
            true
        } catch (ex: Exception){
            false
        }
    }
}