#!/bin/bash

# This script assumes the student's repo has been cloned manually. The student 
# should have logged onto BitBucket.org, found their repo and cloned it. During that process,
# any issues with credentials (such as logging on with a Google-Id) would have been resolved.

# The script will then prompt the user for name, email, cohort and bitbucket team before configuring
# their diff tool settings and setting the upstream repository.

echo
read -r -p "Enter your name (First Last): " name
read -r -p "Enter your email: " email
# read -r -p "Enter your cohort (c or java): " cohort
# read -r -p "Enter your bitbucket team (e.g. te-cin-cohort-4): " team

echo
echo "Setting Up Global Configuration Settings"

git config --global user.name "${name}"
git config --global user.email "${email}"

echo "Setting up Git Editors and Tools..."

git config --global core.editor "code -w -n"
git config --global diff.tool code
git config --global difftool.code.cmd "code -w -d \$LOCAL \$REMOTE"

echo
echo "Configuring Upstream..."

git remote add upstream "https://bitbucket.org/te-det-phl-summer-2020/java-main"
git config branch.master.mergeOptions "--no-edit"

echo "Done."