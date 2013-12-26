/*
 *  Copyright 2010-2013 Robert Burrell Donkin
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.itstechupnorth.sekhmet.audio.sink;

import java.util.concurrent.BlockingQueue;

import org.itstechupnorth.sekhmet.audio.data.AudioData;
import org.itstechupnorth.sekhmet.audio.data.SignalData;


public class TraceSink extends AbstractSink {

    public TraceSink(BlockingQueue<SignalData> queue) {
        super(queue);
    }

    @Override
    protected void use(AudioData buffer) {
        buffer.trace(System.out);
    }

    @Override
    protected void posthumous() {
    }

}