[![Main branch build status](https://github.com/grace-plugins/grace-unpoly/workflows/Grace%20CI/badge.svg?style=flat)](https://github.com/grace-plugins/grace-unpoly/actions?query=workflow%3A%Grace+CI%22)
[![Apache 2.0 license](https://img.shields.io/badge/License-APACHE%202.0-green.svg?logo=APACHE&style=flat)](https://opensource.org/licenses/Apache-2.0)
[![Latest version on Maven Central](https://img.shields.io/maven-central/v/org.graceframework.plugins/unpoly.svg?label=Maven%20Central&logo=apache-maven&style=flat)](https://search.maven.org/search?q=g:org.graceframework.plugins)

# Grace with Unpoly

Grace Plugin for using Grace/Grails app with [Unpoly.js](https://unpoly.com).


## Usage

Add dependency to the `build.gradle`,

```gradle

repositories {
    mavenCentral()
}

dependencies {
    implementation "org.graceframework.plugins:unpoly:VERSION"
}
```

Unpoly plugin supports controller-specific `withFormat()` method,

```groovy
class BookController {

    def list() {
        def books = Book.list()

        withFormat {
            unpoly {
                render(template: "book", model: [bookList: books])
            }
            json {
                render books as JSON
            }
        }
    }
}
```

Also, this plugin supports extendsions for Grails Request and Response,

```groovy
// You can get unpoly request headers from Grails Request

request.unpoly.version == request.getHeader('X-UP-Version')
request.unpoly.target  == request.getHeader('X-UP-Target')

// Check Unpoly request?
if (request.unpoly as boolean) { // or use request.isUnpoly()
    template = 'book-detail'
}

// You can set Unpoly response headers in Grails

response.unpoly.target = '.content'
response.unpoly.events = JsonOutput.toJson([["type": "itemDeleted"]])

```
If you use [`respond`](https://grails.github.io/legacy-grails-doc/4.0.0/ref/Controllers/respond.html) method introduced in Grails 2.3. The `respond` method tries to produce the most appropriate response for the requested content type (JSON, XML, HTML etc.)

You can [configure mime types](https://grails.github.io/legacy-grails-doc/4.0.0/guide/theWebLayer.html#contentNegotiation) for Unpoly.

Update the `app/conf/application.yml`:

```yml
grails:
    mime:
        types:
            up: text/html
```

For example given the show action:

```groovy
def show(Book book) {
    respond book
}
```

You could supply a `show.up.gsp` file to render the Unpoly:

```html
<div id="${book.id}">
    <h1>${book.title}</h1>
    <p>${book.description}</p>
</div>
```


## Development

### Build from source

```
git clone https://github.com/grace-plugins/grace-unpoly.git
cd grace-unpoly
./gradlew publishToMavenLocal
```

## Support Version

* Grace 2022.0.0+
* Grails 3.0+

## Roadmap

### 1.x

* Unpoly 3.x

## License

This plugin is available as open source under the terms of the [APACHE LICENSE, VERSION 2.0](http://apache.org/Licenses/LICENSE-2.0)

## Links

- [Grace Framework](https://github.com/graceframework/grace-framework)
- [Grace Plugins](https://github.com/grace-plugins)
- [Grace Unpoly Plugin](https://github.com/grace-plugins/grace-unpoly)
- [Unpoly](https://unpoly.com)
