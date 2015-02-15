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
package org.cloudfoundry.identity.uaa.api.client;

import org.cloudfoundry.identity.uaa.api.client.model.UaaClient;
import org.cloudfoundry.identity.uaa.api.common.model.PagedResult;
import org.cloudfoundry.identity.uaa.api.common.model.expr.FilterRequest;

/**
 * @author Josh Ghiloni
 *
 */
public interface UaaClientOperations {
	public UaaClient create(UaaClient client);

	public UaaClient findById(String clientId);

	public UaaClient update(UaaClient updated);

	public UaaClient delete(String clientId);
	
	public PagedResult<UaaClient> getClients(FilterRequest request);
	
	public boolean changeClientSecret(String clientId, String oldSecret, String newSecret);
}