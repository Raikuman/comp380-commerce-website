# COMP 380 E-Commerce Website
Our project revolves around creating an E-Commerce website, fully functional, for a user!

# Cloning the repository to your IDE
## Eclipse
1. Install EGIT - Git Integration for Eclipse
    1. 'Help -> Eclipse Marketplace'
    2. Search for egit
    3. Install
    4. Eclipse will ask you to restart
2. To show the Git Repositories window:
    1. 'Window -> Show View -> Other'
    2. In this window: 'Git -> Git Repositories'
3. In the Git Repositories window, click on the 'Clone a Git Repository and add it to this view'
    1. You will need to go to your Github account and create a Personal Access Token
    2. In the 'Clone Git Repository' window in Eclipse, enter https://github.com/Raikuman/comp380-commerce-website.git in the URI field
    3. Enter your Github User ID in the 'Authentication' section
    4. For the password field, enter your Personal Access Token
    5. You are then able to select which branch to clone. Select 'main'
    6. The Github repository should be listed in the 'Git Repositories' window
4. Right-click the 'comp380-commerce-website' repository and select 'Import Projects' to import the repository to your workspace

## Intellij
1. Intellij IDEA has Git and Github integration by default, so no installation of plugins is needed, but you will need to log into your Github account:
    1. 'File -> Settings'
    2. Under 'Version Control' select 'Github'
    3. Add your Github account to the list by selecting the '+' icon
    4. It may redirect you to your Github profile, where you must authorize Intellij to access your Github account
2. Create a new project in Intellij
3. 'VCS' -> 'Get from Version Control...'
4. In the 'URL' field, enter https://github.com/Raikuman/comp380-commerce-website and clone
5. If the project is asking you to select a JDK, select JDK 11

## jGRASP
jGRASP does not have a git module. Instead, the use of git itself is needed. Download Git from here: https://git-scm.com/downloads

Alternatively, you can download any files we have changed and update your project that way and upload your own files to the repository.
