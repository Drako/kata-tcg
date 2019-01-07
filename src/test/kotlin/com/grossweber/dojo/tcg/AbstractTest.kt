package com.grossweber.dojo.tcg

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.koin.log.EmptyLogger
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin
import org.koin.test.KoinTest

abstract class AbstractTest : KoinTest {
  @BeforeEach
  fun before() {
    startKoin(listOf(TcgModule), logger = EmptyLogger())
  }

  @AfterEach
  fun after() {
    stopKoin()
  }
}
