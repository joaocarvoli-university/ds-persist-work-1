package model

data class Product(
  val name: String,
  val price: Double,
  val manufacturer: String,
  val manufacturingDate: String,
  val expirationDate: String,
  val category: Category
) {
  constructor() : this("", (0).toDouble(), "", "", "", Category())
}
