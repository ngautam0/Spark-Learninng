import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object DataMungingYahoo {
  def main(args: Array[String]){
    
    val conf = new SparkConf().setAppName("YahooStocks").setMaster("local")
    val sc = new SparkContext(conf)
    
    val filepath = "./data/yahoo_stocks.csv"
    val wholeData = sc.textFile(filepath)
    
    val yearToBeFiltered = "2010"
    
    val header = wholeData.first()
    val dataWithoutHeader = wholeData.filter(row => row != header)
     
    
    val eachRecordAsList = dataWithoutHeader.map(row => row.split(',').toList)
    
    val filteredList = eachRecordAsList.filter(row => row(0).contains(yearToBeFiltered))
    
    val filteredDataAsString = filteredList.map(row => row.mkString(","))
    
    
    filteredDataAsString.saveAsTextFile("./data/filtered")    
  }
}