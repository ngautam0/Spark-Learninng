import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object FilterExample {
  def main(args : Array[String]){
    
    val conf = new SparkConf().setAppName("Filter").setMaster("local")
    val sc = new SparkContext(conf)

    val textFile = sc.textFile("./data/words.txt")
    
    val filteredLines = textFile.flatMap(line => line.split(" ")).filter(_.length < 5)
    
    filteredLines.saveAsTextFile("./data/filtered")
    
  }
}