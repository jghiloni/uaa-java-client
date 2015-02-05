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
package org.cloudfoundry.identity.uaa.api.client.model;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.util.Assert;

/**
 * @author Josh Ghiloni
 *
 */
public class PagedResult<T> implements Iterable<T> {

	private Collection<T> results;

	private int start = -1;

	private int count = -1;

	public PagedResult(Collection<T> results, int start, int count) {
		Assert.notNull(results);
		Assert.state(start >= 0);
		Assert.state(count >= 0);
		
		this.results = results;
		this.start = start;
		this.count = count;
	}

	public int getStart() {
		return start;
	}

	public int getCount() {
		return count;
	}

	public Iterator<T> iterator() {
		return results.iterator();
	}
}
