# CodeKamp Connections API

# Contacts [/contacts]
User resource.

## List Contacts [GET /contacts{?page,limit}]
Lists all the contacts with pagination of 10 contacts per page
All available filters are mentioned in parameters

+ Parameters
    + type: (enum('and', 'or'), optional) - Decides whether the result will be conjunction or intersection of queried filters.
    + interested_in_technology: (technology:slug, optional) - Returns Contact(s) Interested in given Technology.
    + known_technology: (technology:slug, optional) - Returns Contact(s) who know given Technology.
    + email_not_sent_since: (Y-m-d H:i:s, optional) - Returns Contact(s) to whom e-mail hasn't been sent since given timestamp.
    + sms_not_sent_since: (Y-m-d H:i:s, optional) - Returns Contact(s) to whom sms hasn't been sent since given timestamp.
    + call_not_sent_since: (Y-m-d H:i:s, optional) - Returns Contact(s) who haven't been called since given timestamp.
    + action_not_taken_since: (Y-m-d H:i:s, optional) - Returns Contact(s) to whom any of the actions hasn't been taken since given timestamp.
    + email_opened_id: (email:id, optional) - Returns Contact(s) who have opened the email with given email id.
    + email_clicked_id: (email:id, optional) - Returns Contact(s) who have clicked the email with given email id.
    + email_not_opened_id: (email:id, optional) - Returns Contact(s) who haven't opened the email with given email id.
    + email_not_clicked_id: (email:id, optional) - Returns Contact(s) who haven't clicked the email with given email id.
    + email_opened_all_last: (integer, optional) - Returns Contact(s) who have opened last 'n' number of emails sent.
    + email_clicked_all_last: (integer, optional) - Returns Contact(s) who have clicked last 'n' number of emails sent.
    + email_opened_any_last: (integer, optional) - Returns Contact(s) who have opened any of the last 'n' number of emails sent.
    + email_clicked_any_last: (integer, optional) - Returns Contact(s) who have clicked any of the last 'n' number of emails sent.

## Show Contact [GET /contacts/{id}]
Fetch details of a single contact

## Store Contact [POST /contacts]
Creates a Contact for given details

+ Request (application/x-www-form-urlencoded)
    + Body

                 *     first_name: (alpha_spaces, optional) - First name of Contact.
                 *     last_name: (alpha_spaces, optional) - First name of Contact.
                 *     birthday: (date, optional) - Birthday of Contact.
                 *     emails: (array(email), optional) - E-mail ids of Contact.
                 *     phones: (array(Phone Number in E164 Format), optional) - Phone Numbers of Contact.
                 *     ug_college_id: (colleges:id, optional) - UG College of Contact.
                 *     ug_course_id: (ug_courses:id, optional) - UG Course of Contact.
                 *     ug_entry_year: (integer, optional) - Year when Contact underwent UG.
                 *     pg_college_id: (colleges:id, optional) - PG College of Contact.
                 *     pg_course_id: (pg_courses:id, optional) - PG Course of Contact.
                 *     pg_entry_year: (integer, optional) - Year when Contact underwent PG.
                 *     facebook_id: (string, optional) - Facebook id of Contact.
                 *     linkedin_id: (string, optional) - LinkedIn id of Contact.

## Update Contact [PUT /contacts/{id}]
Update Contact Details of given id

+ Request (application/x-www-form-urlencoded)
    + Body

                 *     first_name: (alpha_spaces, optional) - First name of Contact.
                 *     last_name: (alpha_spaces, optional) - First name of Contact.
                 *     birthday: (date, optional) - Birthday of Contact.
                 *     emails: (array(email), optional) - E-mail ids of Contact.
                 *     phones: (array(Phone Number in E164 Format), optional) - Phone Numbers of Contact.
                 *     ug_college_id: (colleges:id, optional) - UG College of Contact.
                 *     ug_course_id: (ug_courses:id, optional) - UG Course of Contact.
                 *     ug_entry_year: (integer, optional) - Year when Contact underwent UG.
                 *     pg_college_id: (colleges:id, optional) - PG College of Contact.
                 *     pg_course_id: (pg_courses:id, optional) - PG Course of Contact.
                 *     pg_entry_year: (integer, optional) - Year when Contact underwent PG.
                 *     facebook_id: (string, optional) - Facebook id of Contact.
                 *     linkedin_id: (string, optional) - LinkedIn id of Contact.

## Delete User [DELETE /contacts/{id}]
Deletes the contact of given id

# Remarks [/remarks]
Class RemarkController

## GET


## GET


## PUT


+ Request (application/x-www-form-urlencoded)
    + Body

            user_id:45&remark:someRemark&detail:detailOfTheRemark&action_id:34

## POST


+ Request (application/x-www-form-urlencoded)
    + Body

            user_id:34&remark:someRemark&detail:detailOfTheRemark&action_id:45

## DELETE


# Actions [/actions]
Action resource.

## List Actions [GET /actions{?page,limit}]
Lists all the actions with pagination of 10 contacts per page
actions are of three types: CallAction, EmailAction and SmsAction

+ Parameters
    + type: (enum('sms', 'email', 'call'), optional) - If passed, Returns specific type Action(s).
    + contact_id: (contacts:id, optional) - If passed, Returns Action(s) on passed Contact Id.

## Show Action [GET /actions/{id}]
Fetch details of a single action

## Delete Action [DELETE /actions/{id}]
Deletes the action of given id

# Batches [/batches]
Class BatchController

## GET


## GET


## POST


## DELETE
