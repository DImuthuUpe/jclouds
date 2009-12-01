/**
 *
 * Copyright (C) 2009 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 */
package org.jclouds.scriptbuilder.domain;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * @author Adrian Cole
 */
@Test(groups = "unit", testName = "scriptbuilder.CallTest")
public class CallTest {

   public void testCallNoArgsUNIX() {
      Call call = new Call("help");
      assertEquals(call.render(OsFamily.UNIX), "help || return 1\n");
   }

   public void testCallNoArgsWINDOWS() {
      Call call = new Call("help");
      assertEquals(call.render(OsFamily.WINDOWS), "call :help\r\nif errorlevel 1 goto abort\r\n");
   }

   public void testCallArgsUNIX() {
      Call call = new Call("help", "me", "rhonda");
      assertEquals(call.render(OsFamily.UNIX), "help me rhonda || return 1\n");
   }

   public void testCallArgsWINDOWS() {
      Call call = new Call("help", "me", "rhonda");
      assertEquals(call.render(OsFamily.WINDOWS),
               "call :help me rhonda\r\nif errorlevel 1 goto abort\r\n");
   }
}
