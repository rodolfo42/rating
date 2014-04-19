package db

import model._

object DB {

    val dude = Developer("The Dude", "dude@bides.com")
    val walter = Developer("Walter Sobchak", "walter@sobchak.com")

    val ripple = Project("ripplejs/ripple", List(dude rates 3, walter rates 5))
    val trianglify = Project("qrohlf/trianglify", List(walter rates 2, dude rates 1))
    val bootflat = Project("flathemes/bootflat", List(dude rates 5, walter rates 4))

    lazy val allProjects = List(ripple, trianglify, bootflat)
}