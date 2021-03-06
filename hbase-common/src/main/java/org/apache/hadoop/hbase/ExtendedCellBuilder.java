/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hbase;

import org.apache.yetus.audience.InterfaceAudience;

/**
 * For internal purpose.
 * {@link Tag} and memstoreTS/mvcc are internal implementation detail
 *  that should not be exposed publicly.
 * Use {@link ExtendedCellBuilderFactory} to get ExtendedCellBuilder instance.
 * TODO: ditto for ByteBufferCell?
 */
@InterfaceAudience.Private
public interface ExtendedCellBuilder extends CellBuilder {
  @Override
  ExtendedCellBuilder setRow(final byte[] row);
  @Override
  ExtendedCellBuilder setRow(final byte[] row, final int rOffset, final int rLength);

  @Override
  ExtendedCellBuilder setFamily(final byte[] family);
  @Override
  ExtendedCellBuilder setFamily(final byte[] family, final int fOffset, final int fLength);

  @Override
  ExtendedCellBuilder setQualifier(final byte[] qualifier);
  @Override
  ExtendedCellBuilder setQualifier(final byte[] qualifier, final int qOffset, final int qLength);

  @Override
  ExtendedCellBuilder setTimestamp(final long timestamp);

  @Override
  ExtendedCellBuilder setType(final DataType type);

  ExtendedCellBuilder setType(final byte type);

  @Override
  ExtendedCellBuilder setValue(final byte[] value);
  @Override
  ExtendedCellBuilder setValue(final byte[] value, final int vOffset, final int vLength);

  @Override
  ExtendedCell build();

  @Override
  ExtendedCellBuilder clear();

  ExtendedCellBuilder setTags(final byte[] tags);
  ExtendedCellBuilder setTags(final byte[] tags, int tagsOffset, int tagsLength);

  ExtendedCellBuilder setSequenceId(final long seqId);
}
