/*
 *  This file is part of AndroidIDE.
 *
 *  AndroidIDE is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  AndroidIDE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.itsaky.androidide.javac.services.compiler

import com.itsaky.androidide.javac.services.util.JavacTaskUtil
import com.sun.tools.javac.api.JavacTaskImpl

/** @author Akash Yadav */
class ReusableBorrow internal constructor(private val reusableCompiler: ReusableCompiler, @JvmField val task: JavacTaskImpl) :
  AutoCloseable {

  private var closed = false

  override fun close() {
    if (closed) {
      return
    }
    // not returning the context to the pool if task crashes with an exception
    // the task/context may be in a broken state
    reusableCompiler.currentContext!!.clear()
    JavacTaskUtil.cleanup(task)
    reusableCompiler.checkedOut = false
    closed = true
  }
}
