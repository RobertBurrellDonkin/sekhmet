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
package org.itstechupnorth.sekhmet.reader;

import java.io.IOException;

public class AppWrangler {

    private final String base;
    private final String path;

    private Global global;
    private Directory directory;

    public AppWrangler(String base) {
        super();
        this.base = base;
        this.path = Global.toPath(base);
        directory = new Directory();
    }

    public AppWrangler start(String bundleName) throws IOException {
        if (global == null) {
            this.global = new Global();
        }
        final AppBundle bundle = new AppBundle(bundleName, global, directory);
        bundle.start();
        return this;
    }

    public PlainText readRelative(String name) throws IOException {
        return PlainText.read(path + name);
    }

    public String getBase() {
        return base;
    }

    public Global getGlobal() {
        return global;
    }

    @Override
    public String toString() {
        return "AppWrangler [base=" + base + "]";
    }
}
