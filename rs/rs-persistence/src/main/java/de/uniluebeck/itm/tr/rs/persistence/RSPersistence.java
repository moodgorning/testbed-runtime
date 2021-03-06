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

package de.uniluebeck.itm.tr.rs.persistence;

import eu.wisebed.api.rs.ConfidentialReservationData;
import eu.wisebed.api.rs.RSExceptionException;
import eu.wisebed.api.rs.ReservervationNotFoundExceptionException;
import eu.wisebed.api.rs.SecretReservationKey;
import org.joda.time.Interval;

import java.util.List;

/**
 *
 */
public interface RSPersistence {

	/**
	 * @param reservationData
	 * @return
	 */
	SecretReservationKey addReservation(ConfidentialReservationData reservationData, String urnPrefix) throws Exception;

	/**
	 * @param interval
	 * @return
	 * @throws RSExceptionException Important: Intervals are inclusive of the start instant and exclusive of the end
	 */
	List<ConfidentialReservationData> getReservations(Interval interval) throws RSExceptionException;

	/**
	 * @param secretReservationKey
	 * @return
	 * @throws RSExceptionException
	 * @throws eu.wisebed.api.rs.ReservervationNotFoundExceptionException
	 *
	 */
	ConfidentialReservationData getReservation(SecretReservationKey secretReservationKey) throws
			ReservervationNotFoundExceptionException, RSExceptionException;

	/**
	 * @param secretReservationKey
	 * @throws eu.wisebed.api.rs.ReservervationNotFoundExceptionException
	 *
	 * @throws RSExceptionException
	 */
	ConfidentialReservationData deleteReservation(SecretReservationKey secretReservationKey) throws
			ReservervationNotFoundExceptionException, RSExceptionException;
}
