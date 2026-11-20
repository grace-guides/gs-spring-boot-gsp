package grace.guides

import grails.util.Metadata

class GreetingTagLib {

    def welcome = { args, body ->
        out << "Welcome to Grace " << Metadata.current.getGrailsVersion()
    }
}