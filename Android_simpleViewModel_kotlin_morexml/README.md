# SimpleViewModel
Guide on how to set up an app using a ViewModel (MVVM Architecture).
## Description
This is a really simple app: we are just able to temporarily set a name and navigate between two fragments. However, it is interesting to see what's going on behind the scene\
We use a ViewModel because it can survive configuration changes and we can use it to store our data. It is also import for detatching the UI from the logic of our app.\
Here I try to show how it could be implemented: it is a rather simple example, but for the purpose of this guide is all we need.\ 
## Important notes
In the second fragment the ViewModel is really not needed, but it gives e the opportunity to show how to properly instanciate a viewModel using a constructor with parameters.\
It is important to know that if the app is killed in background or is definitly closed, the viewModel will be destroyed as well, and along with it our data.\ 
