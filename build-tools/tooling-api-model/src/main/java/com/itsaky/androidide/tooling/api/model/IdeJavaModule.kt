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

package com.itsaky.androidide.tooling.api.model

import java.io.File

/**
 * A java library model. Modules represented by this model does not apply any of the Android
 * plugins.
 *
 * @author Akash Yadav
 */
class IdeJavaModule(
    name: String?,
    path: String?,
    description: String?,
    projectDir: File?,
    buildDir: File?,
    buildScript: File?,
    parent: IdeGradleProject?,
    tasks: List<IdeGradleTask>,

    /** * Source directories of this project. */
    val contentRoots: List<JavaContentRoot>,

    /** Dependencies of this project. */
    val dependencies: List<JavaModuleDependency>
) : IdeGradleProject(name, description, path, projectDir, buildDir, buildScript, parent, tasks) {}