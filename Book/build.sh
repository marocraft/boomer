if [ ${TRAVIS_PULL_REQUEST} = 'false' ] && [[ $TRAVIS_BRANCH = 'master'  ||  ${TRAVIS_BRANCH} = 'develop' ]]; then
      echo 'Checking Quality Gates'
      mvn -B clean verify sonar:sonar \
      -Dsonar.host.url=https://sonarcloud.io/dashboard?id=Nourelhouda1995_Boomer \
      -Dsonar.login=nourelhouda1995 \
      -Dsonar.projectKey=Nourelhouda1995_Boomer\
      -Dsonar.organization=nourelhouda1995-github
elif [ ${TRAVIS_PULL_REQUEST} != 'false' ]; then
      echo 'Build and analyze pull request'
      mvn -B clean verify sonar:sonar -Dsonar.analysis.mode=issues -Dsonar.host.url=https://sonarcloud.io/dashboard?id=Nourelhouda1995_Boomer -Dsonar.login=nourelhouda1995 -Dsonar.organization=nourelhouda1995-github -Dsonar.github.oauth=b5f7cdbab57d8a472de303c399b16ce8c888ea89 -Dsonar.github.repository=Nourelhouda1995/Boomer2 -Dsonar.github.pullRequest=${TRAVIS_PULL_REQUEST};
fi