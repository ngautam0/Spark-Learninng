import org.apache.spark.SparkContext, org.apache.spark.SparkConf

object SimpleApp {
  def main(args: Array[String]) {
    
    // expects two arguments.. cluster mode and file path where data has to be dumped.
    
    // Pass local as of now to run it on the PC.
    
    // creating spark context
    val conf = new SparkConf().setAppName("scala spark").setMaster(args(0))
    
    val sc = new SparkContext(conf)
    
    // Creating a list
    val i = List(1, 2, 3, 4, 5)
    
    // Converting it into an RDD
    val dataRDD = sc.parallelize(i)
    
    // Write the RDD Back into the specified file path
    dataRDD.saveAsTextFile(args(1))
  }
}