package org.graceframework.plugins.unpoly

import grails.boot.Grails
import grails.plugins.metadata.PluginSource

@PluginSource
class Application {

    static void main(String[] args) {
        Grails.run(Application, args)
    }

}
