/*****************************************************************************
 * Copyright (c) 2013, theborakompanioni (http://www.example.org)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ****************************************************************************/
package at.pollux.thymeleaf.shiro.processor.element;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;

import at.pollux.thymeleaf.shiro.processor.ShiroFacade;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class PrincipalElementProcessor extends AbstractElementTagProcessor {



    private static final String ELEMENT_NAME = "principal";
    private static final int PRECEDENCE = 300;

    public PrincipalElementProcessor(String dialectPrefix) {
        super(
                TemplateMode.HTML, // This processor will apply only to HTML mode
                dialectPrefix, // Prefix to be applied to name for matching
                ELEMENT_NAME, // Tag name: match specifically this tag
                true, // Apply dialect prefix to tag name
                null, // No attribute name: will match by tag name
                false, // No prefix to be applied to attribute name
                PRECEDENCE); // Precedence (inside dialect's own precedence)
    }

//    @Override
//    public int getPrecedence() {
//        return PRECEDENCE;
//    }
//
//    @Override
//    protected String getText(final Arguments arguments, final Element element) {
//        final String type = element.getAttributeValue("type");
//        final String property = element.getAttributeValue("property");
//
//        return ShiroFacade.getPrincipalText(type, property);
//    }

    protected void doProcess(ITemplateContext iTemplateContext, IProcessableElementTag iProcessableElementTag, IElementTagStructureHandler iElementTagStructureHandler) {

        final String type = iProcessableElementTag.getAttributeValue("type");
        final String property = iProcessableElementTag.getAttributeValue("property");

        String text = ShiroFacade.getPrincipalText(type, property);
        iElementTagStructureHandler.replaceWith(text, false);

    }
}