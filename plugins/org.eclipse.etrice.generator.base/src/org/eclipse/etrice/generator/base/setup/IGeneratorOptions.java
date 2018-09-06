/*******************************************************************************
* Copyright (c) 2018 protos software gmbh (http://www.protos.de).
* All rights reserved.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* CONTRIBUTORS:
*           Jan Belle (initial contribution)
*
 *******************************************************************************/

package org.eclipse.etrice.generator.base.setup;

import org.eclipse.etrice.generator.base.args.IOptionModule;

import com.google.inject.ImplementedBy;

/**
 * Interface for generator options.
 */
@ImplementedBy(GeneratorBaseOptions.class)
public interface IGeneratorOptions extends IOptionModule {

}
