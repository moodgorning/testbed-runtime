/**********************************************************************************************************************
 * Copyright (c) 2010, Institute of Telematics, University of Luebeck                                                 *
 * All rights reserved.                                                                                               *
 *                                                                                                                    *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the   *
 * following conditions are met:                                                                                      *
 *                                                                                                                    *
 * - Redistributions of source code must retain the above copyright notice, this list of conditions and the following *
 *   disclaimer.                                                                                                      *
 * - Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the        *
 *   following disclaimer in the documentation and/or other materials provided with the distribution.                 *
 * - Neither the name of the University of Luebeck nor the names of its contributors may be used to endorse or promote*
 *   products derived from this software without specific prior written permission.                                   *
 *                                                                                                                    *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, *
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE      *
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,         *
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE *
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF    *
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY   *
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.                                *
 **********************************************************************************************************************/

package de.uniluebeck.itm.wisebed.cmdlineclient.jobs;

import java.util.HashMap;

import org.joda.time.DateTime;

import de.uniluebeck.itm.wisebed.cmdlineclient.jobs.Job.JobType;

public class JobResult {
	// NodeId -> Result
	private HashMap<String, Result> results = new HashMap<String, Result>();
	
	private final JobType jobType;

	private DateTime startTime;

	private DateTime endTime;

	private String description;

	public static class Result {
		public String message;

		public boolean success;

		public Result(boolean success, String message) {
			this.success = success;
			this.message = message;
		}
	}

	public JobResult(JobType jobType) {
		this.jobType = jobType;
		
	}

	public void addResult(String nodeId, boolean success, String message) {
		results.put(nodeId, new Result(success, message));
	}

	public int getSuccessPercent() {
		int success = 0;
		int failed = 0;

		for (Result r : results.values())
			if (r.success)
				success++;
			else
				failed++;

		if (success + failed > 0)
			return (int) (100.0 * ((double) success / (double) (success + failed)));
		else
			return 100;
	}

	public JobType getJobType() {
		return jobType;
	}

	public HashMap<String, Result> getResults() {
		return results;
	}

	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}

	public DateTime getStartTime() {
		return startTime;
	}

	public DateTime getEndTime() {
		return endTime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
