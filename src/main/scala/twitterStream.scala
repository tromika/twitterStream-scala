package com.tromika.twitterStream
 
import twitter4j._

trait TwitterInstance {
  val twitter = new TwitterStreamFactory().getInstance
}


object StreamSearch extends TwitterInstance{
  def main(args: Array[String]) {
  	//Add new listener
    twitter.addListener(Util.simpleStatusListener)
    //Filter Stream by keyword
    twitter.filter(new FilterQuery().track(args))
    Thread.sleep(1000)
    twitter.cleanUp
    twitter.shutdown
  }
}

object Util {
   def simpleStatusListener = new StatusListener() {
   	  //On new status update print the user's name and the tweet to the console
	  def onStatus(status: Status) { println(status.getUser().getScreenName()+" "+status.getText) }
	  def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) {}
	  def onTrackLimitationNotice(numberOfLimitedStatuses: Int) {}
	  def onException(ex: Exception) { ex.printStackTrace }
	  def onScrubGeo(arg0: Long, arg1: Long) {}
	  def onStallWarning(warning: StallWarning) {}
  }	
}