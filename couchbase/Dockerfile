FROM couchbase

COPY configureCouchbase.sh /opt/couchbase

#CMD ["chmod", "+x", "/opt/couchbase/configureCouchbase.sh"]
CMD ["/opt/couchbase/configureCouchbase.sh"]

EXPOSE 27170