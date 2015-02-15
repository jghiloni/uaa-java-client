/*
 * Copyright 2015 ECS Team, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cloudfoundry.identity.uaa.api.user;

import org.cloudfoundry.identity.uaa.api.common.model.PagedResult;
import org.cloudfoundry.identity.uaa.api.common.model.UaaCredentials;
import org.cloudfoundry.identity.uaa.api.common.model.expr.FilterRequest;
import org.cloudfoundry.identity.uaa.api.user.model.UaaUser;

/**
 * Provides endpoints to the UAA user APIs specified <a
 * href="https://github.com/cloudfoundry/uaa/blob/master/docs/UAA-APIs.rst#user-account-management-apis">here</a>
 * 
 * @author Josh Ghiloni
 *
 */
public interface UaaUserOperations {
	/**
	 * Create the user in the UAA database with the given parameters.
	 * 
	 * @param user The (partial) user information to be created
	 * @return The newly created user. Will have id and meta information set
	 */
	public UaaUser createUser(UaaUser user);

	/**
	 * Update the user in the UAA database. Cannot use this method to change the user's password.
	 * 
	 * @param user the updated user
	 * @return the user as returned from the UAA api
	 * @see #changeUserPassword(String, String)
	 */
	public UaaUser updateUser(UaaUser user);

	/**
	 * Delete the user from UAA. Will throw an Exception if the operation fails
	 * 
	 * @param userId The id of the user
	 */
	public void deleteUser(String userId);

	/**
	 * Change the given user's password. You must have <code>uaa.admin</code> and <code>password.write</code> scopes in
	 * your {@link UaaCredentials} object. An exception will be thrown if the operation fails.
	 * 
	 * <b>TODO</b>: Add a method to change the current user's password, if not in a client-credential-only scope
	 * 
	 * @param userId the user's id (not their username)
	 * @param newPassword the new password
	 */
	public void changeUserPassword(String userId, String newPassword);

	/**
	 * Looks up a user in the database by their name.
	 * 
	 * @param userName the user's username
	 * @return the user object for this user, or null if the user does not exist or the operation fails
	 * @see #getUsers(FilterRequest)
	 */
	public UaaUser getUserByName(String userName);

	/**
	 * Get a page of users based on the given {@link FilterRequest}
	 * 
	 * @param request the {@link FilterRequest}
	 * @return The page of users. 
	 * @see org.cloudfoundry.identity.uaa.api.common.model.expr.FilterRequestBuilder
	 */
	public PagedResult<UaaUser> getUsers(FilterRequest request);
}
