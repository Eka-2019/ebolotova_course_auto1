# ebolotova_course
# main branch

# The project is created for testing of Report Portal
# There are 2 suits: Login(smoke) and Regression.

# **Smoke suite** includes 1 Login test.

# **Regression suite** includes 2 tests:
# -- Check Empty Dashboard
# -- Add and Delete new dashboard in one session

# All tests suits can be run in two ways: 
# 1) from //test/testrunner folder all suites run under default browser = Chrome:
#    -- LogintoDocker.xml runs smoke suite on LOCALHOST runs in docker locally with default credentials
#    -- LogintoEPAMReportPortalServer.xml runs smoke suite on REMOTE EPAM server with personal credentials
#    -- DashboardRegression.xml runs Regression suites on REMOTE EPAM server.
# 2) using run configuration VM option mvn -DmyVariable=someValue install, in this case default browser can be changed in *.properties files
# -Denv=std runs all suit on REMOTE EPAM server under default browser = chrome 
# -Denv=dev runs runs all suit on REMOTE EPAM server under browser = firefox
# -Denv=docker runs all suits on LOCALHOST under default browser = chrome 





