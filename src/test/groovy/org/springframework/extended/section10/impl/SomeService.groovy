package org.springframework.extended.section10.impl

import org.springframework.context.annotation.Primary
import org.springframework.extended.section10.interfaces.MarkerInterface
import org.springframework.stereotype.Service

@Service
@Primary
class SomeService implements MarkerInterface {
}
