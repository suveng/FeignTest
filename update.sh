#!/usr/bin/env bash
git push origin develop
git push --force github develop

git push origin master
git push --force github master
