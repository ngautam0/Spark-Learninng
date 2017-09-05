import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object FileReadWrite {
  def main(args : Array[String]){
    val conf = new SparkConf().setAppName("FileReadWrite").setMaster("local")
    val sc = new SparkContext(conf)
    
    val textFile = sc.textFile("./data/words.txt")
    
    textFile.saveAsTextFile("./data/rewritten")
  }
}