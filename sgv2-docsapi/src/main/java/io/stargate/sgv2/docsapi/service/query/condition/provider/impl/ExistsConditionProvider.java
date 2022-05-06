/*
 * Copyright The Stargate Authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.stargate.sgv2.docsapi.service.query.condition.provider.impl;

import com.fasterxml.jackson.databind.JsonNode;
import io.stargate.sgv2.docsapi.api.common.properties.document.DocumentProperties;
import io.stargate.sgv2.docsapi.service.query.condition.BaseCondition;
import io.stargate.sgv2.docsapi.service.query.condition.impl.ExistsCondition;
import io.stargate.sgv2.docsapi.service.query.condition.impl.ImmutableExistsCondition;
import io.stargate.sgv2.docsapi.service.query.condition.provider.ConditionProvider;
import java.util.Optional;

/** Special condition provider for the {@link ExistsCondition}. */
public class ExistsConditionProvider implements ConditionProvider {

  /** {@inheritDoc} */
  @Override
  public Optional<? extends BaseCondition> createCondition(
      JsonNode node, DocumentProperties documentProperties, boolean numericBooleans) {
    if (node.isBoolean()) {
      ExistsCondition condition =
          ImmutableExistsCondition.of(node.booleanValue(), documentProperties);
      return Optional.of(condition);
    } else {
      return Optional.empty();
    }
  }
}
