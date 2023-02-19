import jenkins.*
import jenkins.model.* 
import hudson.*
import hudson.model.*
def jenkinsCredentials = com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials(
        com.cloudbees.plugins.credentials.Credentials.class,
        Jenkins.instance,
        null,
        null
);
for (creds in jenkinsCredentials) {
        if(creds.id == "example-cred-id"){
          def gettags = ("git ls-remote --heads https://github-user:tokenG@git@github.com:gravitational/teleport.git").execute()
          return gettags.text.readLines().collect { 
          it.split()[1].replaceAll('refs/heads/', '').replaceAll('refs/tags/', '').replaceAll("\\^\\{\\}", '')
}
        }
}
