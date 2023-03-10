package com.github.howieyoung91.commentwriter.generate

import com.intellij.psi.PsiElementFactory
import com.intellij.psi.PsiMethod


/**
 * @author Howie Young
 * @date 2023/03/09 18:14
 */
interface CodeGenerator {
    fun generate(query: Query, method: PsiMethod, factory: PsiElementFactory): String
}

class Query(text: String = "") {
    var prompt: String = text
        private set

    fun text(text: String) {
        this.prompt = text
    }
}

inline fun Query(init: Query.() -> Unit): Query {
    val query = Query("")
    query.init()
    return query
}
