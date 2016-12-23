package io.github.fixerteam.moviecheck.ui.popular

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import io.github.fixerteam.moviecheck.domain.pojo.Movie
import io.github.fixerteam.moviecheck.ui.base.ListFragment
import io.github.fixerteam.moviecheck.ui.base.mvp.BasePresenter
import io.github.fixerteam.moviecheck.ui.main.MainComponent
import javax.inject.Inject

class PopularFragment : ListFragment<Movie, MovieHolder>(), PopularMoviesContract.View<Movie> {

  @Inject lateinit var presenter: PopularPresenter

  override fun getViewHolder(parent: ViewGroup) = MovieHolder(parent)

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    presenter.attachView(this)
    presenter.onStart()
  }

  override fun getPresenter(): BasePresenter<*, *>? = presenter

  override fun injectDependencies() {
    activityComponent<MainComponent>()
        ?.plusPopularMoviesSubComponent(PopularMoviesModule())
        ?.inject(this)
  }
}