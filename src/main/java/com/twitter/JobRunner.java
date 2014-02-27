package com.twitter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class JobRunner {

	/**
	 * A class that kicks off the TwitterStreamConsumer at the specified start time provided by the user. 
	 * It kills the consumer thread at the specified end time.
	 */
	
	@SuppressWarnings("deprecation")
	public void runJob() throws ParseException, InterruptedException {
		final TwitterStreamConsumer streamConsumer = new TwitterStreamConsumer();

		// Current time
		long currentTime = new Date().getTime();
		// Job start time
		long startTime = Context.START_TIME.getTime();
		// Job end time
		long endTime = Context.END_TIME.getTime();
		//Current execution thread sleeps for initialSleepInterval
		long initialSleepInterval = startTime - currentTime;
		//After initialSleepInterval the current execution thread comes back up, fires the consumer and sleeps again for secondSleepInterval
		long secondSleepInterval = endTime - startTime;
		Thread.sleep(initialSleepInterval);
		streamConsumer.start();
		Thread.sleep(secondSleepInterval);
		//After secondSleepInterval, the consumer is killed
		streamConsumer.stop();
	}
}
