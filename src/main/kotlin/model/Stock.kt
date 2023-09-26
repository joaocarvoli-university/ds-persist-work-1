package model

data class Stock(
  val products: List<Product>
){
  constructor(): this(listOf())
}