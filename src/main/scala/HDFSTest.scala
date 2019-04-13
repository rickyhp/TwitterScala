import java.io.PrintWriter
import java.net.URI

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object HDFSTest extends App {
//  println( "Trying to write to HDFS..." )
//  val conf = new Configuration()
//  //conf.set("fs.defaultFS", "hdfs://quickstart.cloudera:8020")
//  conf.set("fs.defaultFS", "hdfs://localhost:8020")
//  val fs= FileSystem.get(conf)
//  val output = fs.create(new Path("mySample.txt"))
//  val writer = new PrintWriter(output)
//  try {
//    writer.write("this is a test")
//    writer.write("\n")
//  }
//  finally {
//    writer.close()
//    println("Closed!")
//  }

  val hdfs = FileSystem.get(new URI("hdfs://localhost:8020/"), new Configuration())
  val path = new Path("/user/rp/test2.txt")
  val stream = hdfs.open(path)
  def readLines = Stream.cons(stream.readLine, Stream.continually( stream.readLine))

  //This example checks line for null and prints every existing line consequentally
  readLines.takeWhile(_ != null).foreach(line => println("=>"+line))

  println("Done!")

}
